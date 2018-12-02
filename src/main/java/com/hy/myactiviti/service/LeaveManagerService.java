package com.hy.myactiviti.service;

import com.baomidou.mybatisplus.service.IService;
import com.hy.myactiviti.entity.Leave;
import org.activiti.engine.runtime.ProcessInstance;

import java.util.List;
import java.util.Map;

public interface LeaveManagerService extends IService<Leave> {

    ProcessInstance startWorkflow(Leave entity, String userId, Map<String, Object> variables);

    List<Leave> findTodoTasks(String userId);
}
