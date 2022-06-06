package com.sky.parentservice.model;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Dto{

    private Integer mesId;
    private String operation;
    private String type;
    private String timeStamp;
    private String eventId;
    private String category;
    private String subCategory;
    private String name;
    private String starTime;
    private String displayed;
    private String suspended;

}
//|393908|update|outcome|1650904691744|111a40b0-e9e6-4e66-8f0b-fe9842430f2b|978d4bc6-c0c9-4dc2-a3b6-60de2b9d0401|\|Sheffield Utd\| 1-0|9/2|1|0|



/*
 {
	"types": {
		"event": {
			"header": {
				"field": [
					{
						"_index": "0",
						"_name": "msgId",
						"_datatype": "integer"
					},
					{
						"_index": "1",
						"_name": "operation",
						"_datatype": "string"
					},
					{
						"_index": "2",
						"_name": "type",
						"_datatype": "string"
					},
					{
						"_index": "3",
						"_name": "timestamp",
						"_datatype": "integer"
					}
				]
			},
			"body": {
				"field": [
					{
						"_index": "4",
						"_name": "eventId",
						"_datatype": "string"
					},
					{
						"_index": "5",
						"_name": "category",
						"_datatype": "string"
					},
					{
						"_index": "6",
						"_name": "subCategory",
						"_datatype": "string"
					},
					{
						"_index": "7",
						"_name": "name",
						"_datatype": "string"
					},
					{
						"_index": "8",
						"_name": "startTime",
						"_datatype": "integer"
					},
					{
						"_index": "9",
						"_name": "displayed",
						"_datatype": "boolean"
					},
					{
						"_index": "10",
						"_name": "suspended",
						"_datatype": "boolean"
					}
				]
			}
		},
		"market": {
			"header": {
				"field": [
					{
						"_index": "0",
						"_name": "msgId",
						"_datatype": "integer"
					},
					{
						"_index": "1",
						"_name": "operation",
						"_datatype": "string"
					},
					{
						"_index": "2",
						"_name": "type",
						"_datatype": "string"
					},
					{
						"_index": "3",
						"_name": "timestamp",
						"_datatype": "integer"
					}
				]
			},
			"body": {
				"field": [
					{
						"_index": "4",
						"_name": "eventId",
						"_datatype": "string"
					},
					{
						"_index": "5",
						"_name": "marketId",
						"_datatype": "string"
					},
					{
						"_index": "6",
						"_name": "name",
						"_datatype": "string"
					},
					{
						"_index": "7",
						"_name": "displayed",
						"_datatype": "boolean"
					},
					{
						"_index": "8",
						"_name": "suspended",
						"_datatype": "boolean"
					}
				]
			}
		},
		"outcome": {
			"header": {
				"field": [
					{
						"_index": "0",
						"_name": "msgId",
						"_datatype": "integer"
					},
					{
						"_index": "1",
						"_name": "operation",
						"_datatype": "string"
					},
					{
						"_index": "2",
						"_name": "type",
						"_datatype": "string"
					},
					{
						"_index": "3",
						"_name": "timestamp",
						"_datatype": "integer"
					}
				]
			},
			"body": {
				"field": [
					{
						"_index": "4",
						"_name": "marketId",
						"_datatype": "string"
					},
					{
						"_index": "5",
						"_name": "outcomeId",
						"_datatype": "string"
					},
					{
						"_index": "6",
						"_name": "name",
						"_datatype": "string"
					},
					{
						"_index": "7",
						"_name": "price",
						"_datatype": "string"
					},
					{
						"_index": "8",
						"_name": "displayed",
						"_datatype": "boolean"
					},
					{
						"_index": "9",
						"_name": "suspended",
						"_datatype": "boolean"
					}
				]
			}
		}
	}
}
 */