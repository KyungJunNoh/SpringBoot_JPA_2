package jpabook.jpashop.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.*;
import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name = "ORDERS") // ORDER BY 문법과 헷갈릴수 있어서 실무에서는 대부분 Order 관련된 테이블은 ORDERS 라고 표기한다.
public class Order extends BaseEntity{

    @Id @GeneratedValue
    @Column(name = "ORDER_ID")
    private Long id;

    @ManyToOne(fetch = LAZY) // ManyToOne 의 fetch는 default가 "EAGER"
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @OneToOne(fetch = LAZY, cascade = ALL) // @OneToOne 의 fetch는 default가 "EAGER" , ORDER 을 저장할때 자동으로 delivery도 저장 (persist)
    @JoinColumn(name = "DELIVERY_ID")
    private Delivery delivery;

    @OneToMany(mappedBy = "order", cascade = ALL) // @OneToMany 의 fetch는 default가 "LAZY"
    private List<OrderItem> orderItems = new ArrayList<>();

    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;

}
