package net.marco27.api.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "prices")
public class Price implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "source", nullable = false)
    private String source;

    @Column(name = "instrument", nullable = false)
    private String instrument;

    @Column(name = "amount", nullable = false)
    private Double amount;

    @Column(name = "created")
    private String created;

}
