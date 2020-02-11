package jmd.controller;

import jmd.common.ResultInfo;
import jmd.po.Task;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/tasks")
public interface TaskApiController {

    @RequestMapping(value ="/doing/{id}",method= RequestMethod.POST)
    ResultInfo doing(@PathVariable("id") Integer id);

    @RequestMapping(value ="/finished/{id}",method= RequestMethod.POST)
    ResultInfo finished(@PathVariable("id") Integer id);

    @RequestMapping("/list")
    ResultInfo list();

    @RequestMapping(value = "/add",method= RequestMethod.POST)
    ResultInfo add(@RequestBody Task task);

    @RequestMapping(value ="/delete/{id}",method= RequestMethod.POST)
    ResultInfo deleteById(@PathVariable("id") Integer id);

    @RequestMapping("/tasks")
    ResultInfo getTask();

    @RequestMapping("/get-order")
    String getOrder();
}
