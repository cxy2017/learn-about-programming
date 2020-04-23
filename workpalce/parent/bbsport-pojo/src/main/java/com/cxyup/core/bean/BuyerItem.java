package com.cxyup.core.bean;

import java.io.Serializable;
import java.util.Objects;

import com.cxyup.core.bean.product.Sku;

/**
 * 购物项
 * @author lx
 *
 */
public class BuyerItem implements Serializable{


    /**
     *
     */
    private static final long serialVersionUID = 1L;

    //1:SKUID   Sku对象里面有个自己的ID
    private Sku sku;

    //2：Boolean 是否有货;
    private Boolean have = true;

    //3:数量
    private Integer amount = 1;

    public Sku getSku() {
        return sku;
    }

    public void setSku(Sku sku) {
        this.sku = sku;
    }

    public Boolean getHave() {
        return have;
    }

    public void setHave(Boolean have) {
        this.have = have;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "BuyerItem [sku=" + sku + ", have=" + have + ", amount=" + amount + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BuyerItem buyerItem = (BuyerItem) o;
        if (sku==null){
            if (buyerItem.sku!=null){
                return false;
            }
        }
        return Objects.equals(sku.getId(), buyerItem.sku.getId());
    }

    @Override
    public int hashCode() {

        return Objects.hash(sku);
    }
}
