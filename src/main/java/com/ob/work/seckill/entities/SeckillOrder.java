package com.ob.work.seckill.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ob.common.base.domain.BaseStateDomain;
import com.ob.common.base.domain.IdStrategy;
import com.ob.common.convert.BeanConvert;
import com.ob.work.seckill.dto.SeckillOrderResDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.BeanUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @Author: oubin
 * @Date: 2019/12/2 08:49
 * @Description:
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "t_seckill_order")
@GenericGenerator(name = "id", strategy = IdStrategy.UUID)
public class SeckillOrder extends BaseStateDomain<String> {

    /**
     * 用户id
     */
    @JsonProperty("user_id")
    @Column(name = "user_id")
    private String userId;

    /**
     * 商品id
     */
    @JsonProperty("goods_id")
    @Column(name = "goods_id")
    private String goodsId;

    public SeckillOrderResDTO convertToSeckillOrderResDTO() {
        SeckillOrderResDTOConverter converter = new SeckillOrderResDTOConverter();
        return converter.convert(this);
    }

    private static class SeckillOrderResDTOConverter implements BeanConvert<SeckillOrder, SeckillOrderResDTO> {
        @Override
        public SeckillOrderResDTO convert(SeckillOrder seckillOrder) {
            SeckillOrderResDTO resDTO = new SeckillOrderResDTO();
            BeanUtils.copyProperties(seckillOrder, resDTO);
            resDTO.setId(seckillOrder.getId());
            resDTO.setState(seckillOrder.getState());
            return resDTO;
        }
    }
}
