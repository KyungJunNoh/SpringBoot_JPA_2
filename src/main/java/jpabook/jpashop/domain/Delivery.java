package jpabook.jpashop.domain;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
public class Delivery extends BaseEntity{

    @Id @GeneratedValue
    private Long id;

    @OneToOne(mappedBy = "delivery", fetch = LAZY) // @OneToOne 의 fetch는 default가 "EAGER"
    private Order order;

    private String city;

    private String street;

    private String zipcode;

    private DeliveryStatus status;

}
