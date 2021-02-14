package sample.eventuate.order.message.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sample.eventuate.order.message.entity.MessageOrderEntity;

@Repository
public interface MessageOrderRepository extends JpaRepository<MessageOrderEntity, Long>{

}
