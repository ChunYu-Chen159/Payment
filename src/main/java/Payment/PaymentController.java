package Payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;




@Api(value = "PaymentController", tags = "與付錢相關的所有一切都在這裡")
@RestController
public class PaymentController {
	@Autowired
	FeignInterface feignInterface;
	
	
	@ApiOperation(value = "測試此伺服器是否成功連線", notes = "成功連線就回傳success")
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() 
    {
		return "success";
    }
	
	@ApiOperation(value = "購買物品", notes = "成功購買就回傳success")
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "Payment", method = RequestMethod.GET)
    public String payment()
    {
    	return "success";
    }
	
	
}



