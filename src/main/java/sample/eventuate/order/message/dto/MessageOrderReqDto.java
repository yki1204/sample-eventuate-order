package sample.eventuate.order.message.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class MessageOrderReqDto {
	
	private String orderName;
	
	private Long customerId;
	
	private BigDecimal price;

}
