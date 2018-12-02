package com.hy.myactiviti.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hy.myactiviti.entity.Leave;
import com.hy.myactiviti.mapper.LeaveMapper;
import com.hy.myactiviti.service.LeaveManagerService;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.IdentityService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
@Transactional
public class LeaveManagerServiceImpl extends ServiceImpl<LeaveMapper, Leave> implements LeaveManagerService {

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private IdentityService identityService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private RepositoryService repositoryService;


    /**
     * 保存请假实体并启动流程
     */
    @Override
    public ProcessInstance startWorkflow(Leave entity, String userId, Map<String, Object> variables) {
        if (entity.getId() == null) {
            entity.setApplyTime(new Date());
            entity.setUserId(userId);
        }
        this.insertOrUpdate(entity); //持久化业务实体
        String businessKey = entity.getId().toString(); //实体保存后的ID，作为流程的业务Key

        // 用来设置启动流程的人员ID，引擎会自动把用户ID保存到activiti:initiator中
        identityService.setAuthenticatedUserId(userId);

        //启动流程时设置业务Key
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("leave", businessKey, variables);

        String processInstanceId = processInstance.getId();
        entity.setProcessInstanceId(processInstanceId);
        log.debug("start process of {key={}, bkey={}, pid={}, variables={}}", new Object[]{"leave", businessKey,
                processInstanceId, variables});
        this.insertOrUpdate(entity);
        return processInstance;
    }

    /**
     * 查询待办任务
     */
    @Override
    public List<Leave> findTodoTasks(String userId) {

        List<Leave> results = new ArrayList<Leave>();
        List<Task> tasks = new ArrayList<Task>();

        // 根据当前人的ID查询
        List<Task> todoList = taskService.createTaskQuery().processDefinitionKey("leave").taskAssignee(userId).list();

        // 根据当前人未签收的任务
        List<Task> unsignedTasks = taskService.createTaskQuery().processDefinitionKey("leave").taskCandidateUser(userId).list();

        // 合并
        tasks.addAll(todoList);
        tasks.addAll(unsignedTasks);


        // 根据流程的业务ID查询实体并关联
        for (Task task : tasks) {
            String processInstanceId = task.getProcessInstanceId();
            ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();
            String businessKey = processInstance.getBusinessKey();
            Leave leave = this.selectById(new Long(businessKey));
            leave.setTask(task);
            leave.setProcessInstance(processInstance);
            String processDefinitionId = processInstance.getProcessDefinitionId();
            ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().processDefinitionId(processDefinitionId).singleResult();
            leave.setProcessDefinition(processDefinition);
            results.add(leave);
        }
        return results;
    }


}
