package com.hy.myactiviti.controller.leave;

import com.hy.myactiviti.controller.UserUtil;
import com.hy.myactiviti.entity.Leave;
import com.hy.myactiviti.service.LeaveManagerService;
import org.activiti.engine.identity.User;
import org.activiti.engine.runtime.ProcessInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 请假控制器
 *
 * @author henryyan
 */
@Controller
@RequestMapping(value = "/leave")
public class LeaveController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    LeaveManagerService leaveService;


    @RequestMapping(value = {"apply"})
    public String createForm(Model model) {
        model.addAttribute("leave", new Leave());
        return "/leave/leave-apply";
    }

    /**
     * 启动请假流程
     */
    @RequestMapping(value = "start", method = RequestMethod.POST)
    public String startWorkflow(Leave leave, RedirectAttributes redirectAttributes, HttpSession session) {

        User user = UserUtil.getUserFromSession(session);
        Map<String, Object> variables = new HashMap<String, Object>();
        ProcessInstance processInstance = leaveService.startWorkflow(leave, user.getId(), variables);
        redirectAttributes.addFlashAttribute("message", "流程已启动，流程ID：" + processInstance.getId());

        return "redirect:/leave/apply";
    }


    /**
     * 任务列表
     */
    @RequestMapping(value = "task/list")
    public ModelAndView taskList(HttpSession session) {
        ModelAndView mav = new ModelAndView("/leave/leave-task-list");
        String userId = UserUtil.getUserFromSession(session).getId();
        List<Leave> results = leaveService.findTodoTasks(userId);
        mav.addObject("records", results);
        return mav;
    }


}
