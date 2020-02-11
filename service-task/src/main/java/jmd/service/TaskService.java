package jmd.service;

import jmd.dao.TaskMapper;
import jmd.dao.TaskTypeMapper;
import jmd.po.Task;
import jmd.po.TaskExample;
import jmd.po.TaskType;
import jmd.po.TaskTypeExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    public final static Integer TASK_INIT = 0;
    public final static Integer TASK_DOING = 1;
    public final static Integer TASK_FINISH = 2;

    @Autowired
    TaskTypeMapper taskTypeMapper;

    @Autowired
    TaskMapper taskMapper;

    public void doing(Integer id){
        Task task = new Task();
        task.setId(id);
        task.setStatus(TASK_DOING);
        taskMapper.updateByPrimaryKey(task);
    }

    public void finished(Integer id){
        Task task = new Task();
        task.setId(id);
        task.setStatus(TASK_FINISH);
        taskMapper.updateByPrimaryKey(task);
    }

    public List<Task> listTask(){
        TaskExample taskExample = new TaskExample();
        TaskExample.Criteria criteria = taskExample.createCriteria();
        criteria.andStatusNotEqualTo(TASK_FINISH);
        return taskMapper.selectByExample(taskExample);
    }

    public Integer insertTask(Task task){
        task.setStatus(TASK_INIT);
        taskMapper.insertSelective(task);
        return task.getId();
    }

    public void deleteById(Integer id){
        taskMapper.deleteByPrimaryKey(id);
    }

    public List<TaskType> list(){
        return taskTypeMapper.selectByExample(new TaskTypeExample());
    }
}
