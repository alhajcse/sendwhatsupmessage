package com.app.whatsupmessage.entity;

import com.app.whatsupmessage.enums.BlockTypeStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import javax.persistence.*;


@Getter
@Setter
@Entity
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor
@Table(name = "BLOCK_SUBMENU")
public class BlockSubMenu extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BLOCK_SUBMENU_ID")
    private Long id;

    @Column(name = "BLOCK_SUBMENU_NAME")
    private String blockSubMenuName;

    @Column(name = "BLOCK_SUBMENU_DESC")
    private String blockSubMenuDesc;

    @Enumerated(EnumType.STRING)
    @Column(name = "BLOCK_TYPE_STATUS",length = 50)
    private BlockTypeStatus blockTypeStatus;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BLOCK_MENU_ID")
    private BlockMenu blockMenu;
}
