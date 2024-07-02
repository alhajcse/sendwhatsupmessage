package com.app.whatsupmessage.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor
@Table(name = "BLOCK_MENU")
public class BlockMenu extends BaseEntity{

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BLOCK_MENU_ID")
    private Long id;

    @Column(name = "BLOCK_MENU_NAME")
    private String blockMenuName;

    @Column(name = "BLOCK_MENU_DESC")
    private String blockMenuDesc;

    @OneToMany(
            mappedBy = "blockMenu",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<BlockSubMenu> blockSubMenuList;

}
