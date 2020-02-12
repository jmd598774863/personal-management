package jmd.controller;

import jmd.common.ResultInfo;
import jmd.po.Task;
import jmd.po.TaskType;
import jmd.rpcservice.RpcOrderService;
import jmd.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskController implements TaskApiController {

    @Autowired
    RpcOrderService rpcOrderService;

    @Autowired
    TaskService taskService;

    @Override
    public ResultInfo doing(Integer id) {
        taskService.doing(id);
        return new ResultInfo<>();
    }

    @Override
    public ResultInfo finished(Integer id) {
        taskService.finished(id);
        return new ResultInfo<>();
    }

    @Override
    public ResultInfo list() {
        ResultInfo<List<Task>> resultInfo = new ResultInfo<>();
        resultInfo.setData(taskService.listTask());
        return resultInfo;
    }

    @Override
    public ResultInfo add(Task task) {
        ResultInfo<Integer> resultInfo = new ResultInfo<>();
        Integer integer = taskService.insertTask(task);
        resultInfo.setData(integer);
        return resultInfo;
    }

    @Override
    public ResultInfo deleteById(Integer id) {
        ResultInfo<String> resultInfo = new ResultInfo<>();
        taskService.deleteById(id);
        return resultInfo;
    }

    //自己用，或给别人用
    @Override
    public ResultInfo getTask(){
        ResultInfo<List<TaskType>> resultInfo = new ResultInfo<>();
        resultInfo.setData(taskService.list());
        return resultInfo;
    }

    //调用别人
    @Override
    public String getOrder() {
        return "";
//        return rpcOrderService.getOrders();
    }
}
