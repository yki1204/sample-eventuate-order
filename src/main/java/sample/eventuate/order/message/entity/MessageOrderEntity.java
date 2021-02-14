package sample.eventuate.order.message.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name="order_info")
@Entity
@Getter
@NoArgsConstructor
public class MessageOrderEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String orderName;
	
	private Long customerId;
	
	private BigDecimal price;

	@Builder
	public MessageOrderEntity(Long id, String orderName, Long customerId, BigDecimal price) {
		this.id = id;
		this.orderName = orderName;
		this.customerId = customerId;
		this.price = price;
	}
	
}
