package com.example.demo.po;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties(prefix = "foo")
public class FooProperties {

		private String no;

		private int id;

		private String name;

		private Map<String, String> InterestMap;

		public String getNo() {
			return no;
		}

		public void setNo(String no) {
			this.no = no;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Map<String, String> getInterestMap() {
			return InterestMap;
		}

		public void setInterestMap(Map<String, String> interestMap) {
			InterestMap = interestMap;
		}

		@Override
		public String toString() {
			return "FooProperties [no=" + no + ", id=" + id + ", name=" + name + ", InterestMap=" + InterestMap + "]";
		}
		
		
}
