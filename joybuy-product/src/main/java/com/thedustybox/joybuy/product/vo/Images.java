/**
  * Copyright 2023 bejson.com 
  */
package com.thedustybox.joybuy.product.vo;



public class Images {

    private String imgUrl;
    private int defaultImg;
    public void setImgUrl(String imgUrl) {
         this.imgUrl = imgUrl;
     }
     public String getImgUrl() {
         return imgUrl;
     }

    public void setDefaultImg(int defaultImg) {
         this.defaultImg = defaultImg;
     }
     public int getDefaultImg() {
         return defaultImg;
     }

}