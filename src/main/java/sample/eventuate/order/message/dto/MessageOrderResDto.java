package sample.eventuate.order.message.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class MessageOrderResDto {
	
	private Long id;
	
	private String orderName;
	
	private Long customerId;
	
	private BigDecimal price;

}
