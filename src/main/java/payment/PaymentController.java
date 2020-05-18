package payment;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;


@Api(value = "PaymentController", tags = "與付錢相關的所有一切都在這裡")
@RestController
public class PaymentController {

//	@Autowired
//	private AmqpTemplate rabbitTemplate;
//	@Autowired
//	private FanoutExchange fanout; // configured in RabbitConfig


	@RequestMapping(value="/simulateError", method = RequestMethod.GET)
	public String isNumberPrime_payment(@RequestParam("number") Integer number) {
		return number % 2 == 0 ? "Even" : "Odd";
	}


	// 模擬404
	@ApiOperation(value = "模擬500", notes = "回傳500")
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/simulate500", method = RequestMethod.GET)
	public String simulate500()
	{
		int i=5/0;
		return "ex";
	}

	// 模擬404
	@ApiOperation(value = "模擬404", notes = "回傳404")
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/index2", method = RequestMethod.GET)
	public ResponseEntity<Payment> index2()
	{

		return ResponseEntity.notFound().build();
	}

	// 模擬回應
	@ApiOperation(value = "模擬延遲", notes = "回應延遲")
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/index3", method = RequestMethod.GET)
	public String index3()
	{

		String result = "wait success";


		long num = (long)(Math.random() * 30);
		try {
			Thread.sleep(num);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@ApiOperation(value = "測試此伺服器是否成功連線", notes = "成功連線就回傳success")
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/", method = RequestMethod.GET)
	//@Scheduled(fixedDelay = 1000, initialDelay = 500)
//	@RabbitPublisher("date")
    public String index() 
    {
		String context = "now date ".concat(new SimpleDateFormat("yyyy-MM-dd HH:mm:dd").format(new Date()));
		System.out.println("Sender : " + context);
		//rabbitTemplate.convertAndSend(dateQueue.getName(), context);
//		rabbitTemplate.convertAndSend(fanout.getName(),"", context);
    	return "success";
    }

	
	@ApiOperation(value = "購買物品", notes = "成功購買就回傳success")
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "payment", method = RequestMethod.GET)
    public String payment(@ApiParam(required = true, name = "userID", value = "使用者ID")@RequestParam("userID") String userID, @ApiParam(required = true, name = "price", value = "付款金額")@RequestParam("price") String price)
    {
    	return "success";
    }
	
	
}



