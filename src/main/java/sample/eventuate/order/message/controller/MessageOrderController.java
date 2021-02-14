package sample.eventuate.order.message.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import sample.eventuate.order.message.dto.MessageOrderReqDto;
import sample.eventuate.order.message.dto.MessageOrderResDto;
import sample.eventuate.order.message.service.MessageOrderService;

@RestController
@AllArgsConstructor
public class MessageOrderController {
	
	private MessageOrderService messageOrderService;
	
	@GetMapping("/message/orders/v1")
	public List<MessageOrderResDto> retrieveMessageOrderList(){
		
		return messageOrderService.retrieveMessageOrderList();
	}
	
	@PostMapping("/message/orders/v1")
	public Long createMessageOrder(@RequestBody MessageOrderReqDto messageOrderReqDto){
		
		return messageOrderService.createMessageOrder(messageOrderReqDto);
	}

}
