package jmd.rpcservice;

//import jmd.main.OrderService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;

@Service
@FeignClient("service-order")
//public interface RpcOrderService extends OrderService{
public interface RpcOrderService{

}
