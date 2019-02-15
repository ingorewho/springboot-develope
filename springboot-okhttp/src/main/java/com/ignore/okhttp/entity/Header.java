package com.ignore.okhttp.entity;

import lombok.Data;

/**
 * @Author: ignore1992
 * @Description:
 * @Date: Created In 14:56 2019/1/31
 */
@Data
public class Header {
    private String name;
    private String value;

    public Header(Builder builder){
        this.name = builder.name;
        this.value = builder.value;
    }
    public static class Builder{
        private String name;
        private String value;

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder value(String value){
            this.value = value;
            return this;
        }

        public Header build(){
            return new Header(this);
        }
    }
}
