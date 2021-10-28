package jpabook.jpashop.domain;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Entity
public class OrderItem extends BaseEntity{

    @Id @GeneratedValue
    @Column(name = "ORDER_ITEM_ID")
    private Long id;

    @ManyToOne(fetch = LAZY) // @ManyToOne 의 fetch는 default가 "EAGER"
    @JoinColumn(name = "ITEM_ID")
    private Item item;

    @ManyToOne(fetch = LAZY) // @ManyToOne 의 fetch는 default가 "EAGER"
    @JoinColumn(name = "ORDER_ID")
    private Order order;

    private int OrderPrice;

    private int count;

}
