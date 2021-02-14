package sample.eventuate.order.message.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.raon.eventuate.framework.message.RaonMessageProducer;

import lombok.AllArgsConstructor;
import sample.eventuate.order.message.dto.MessageOrderReqDto;
import sample.eventuate.order.message.dto.MessageOrderResDto;
import sample.eventuate.order.message.entity.MessageOrderEntity;
import sample.eventuate.order.message.repository.MessageOrderRepository;

@Service
@Transactional
@AllArgsConstructor
public class MessageOrderService {
	
	private MessageOrderRepository messageOrderRepository;
	
	private RaonMessageProducer messageProducer;
	
	public List<MessageOrderResDto> retrieveMessageOrderList() {
		
		List<MessageOrderEntity> messageOrderEntityList = messageOrderRepository.findAll();
		 
		 return toMessageOrderResDtoList(messageOrderEntityList);
	}
	
	public Long createMessageOrder(MessageOrderReqDto messageOrderReqDto){
		
		MessageOrderEntity messageOrderEntity = MessageOrderEntity.builder()
																.orderName(messageOrderReqDto.getOrderName())
																.customerId(messageOrderReqDto.getCustomerId())
																.price(messageOrderReqDto.getPrice())
																.build();
		
		messageOrderEntity = messageOrderRepository.save(messageOrderEntity);
		
		// message publish to kafka
		messageProducer.send("order-message", toMessageOrderResDto(messageOrderEntity));
		
		return messageOrderEntity.getId();
	}
	
	public MessageOrderResDto toMessageOrderResDto(MessageOrderEntity messageOrderEntity) {
		
		if(messageOrderEntity == null) {
			return null;
		}
		
		MessageOrderResDto messageOrderResDto = new MessageOrderResDto();
		messageOrderResDto.setId(messageOrderEntity.getId());
		messageOrderResDto.setOrderName(messageOrderEntity.getOrderName());
		messageOrderResDto.setCustomerId(messageOrderEntity.getCustomerId());
		messageOrderResDto.setPrice(messageOrderEntity.getPrice());
		
		return messageOrderResDto;
	}
	
	public List<MessageOrderResDto> toMessageOrderResDtoList(List<MessageOrderEntity> messageOrderEntityList) {
		
		if(messageOrderEntityList == null) {
			return null;
		}
		
		List<MessageOrderResDto> messageOrderResDtoList = new ArrayList<>();
		
		for(MessageOrderEntity MessageOrderEntity : messageOrderEntityList) {
			messageOrderResDtoList.add(toMessageOrderResDto(MessageOrderEntity));
		}
		
		return messageOrderResDtoList;
	}

}
