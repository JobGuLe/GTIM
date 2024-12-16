package com.femsa.oxxo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TdgTickets {

	private Integer id;
	private String member_id;
	private String sales_folio;
	private String store_id;
	private Data creation_date;
	private Integer amount;
	private Boolean send_notification;
	
}
