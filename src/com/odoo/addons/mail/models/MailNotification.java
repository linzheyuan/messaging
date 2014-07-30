package com.odoo.addons.mail.models;

import odoo.ODomain;
import android.content.Context;

import com.odoo.base.res.ResPartner;
import com.odoo.orm.OColumn;
import com.odoo.orm.OColumn.RelationType;
import com.odoo.orm.OModel;
import com.odoo.orm.annotations.Odoo;
import com.odoo.orm.types.OBoolean;

public class MailNotification extends OModel {

	@Odoo.api.v7
	OColumn read = new OColumn("Read", OBoolean.class).setDefault(false);

	@Odoo.api.v8
	@Odoo.api.v9alpha
	OColumn is_read = new OColumn("Is Read", OBoolean.class).setDefault(false);
	OColumn starred = new OColumn("Starred", OBoolean.class);
	OColumn partner_id = new OColumn("Partner_id", ResPartner.class,
			RelationType.ManyToOne);
	OColumn message_id = new OColumn("Message_id", MailMessage.class,
			RelationType.ManyToOne);

	public MailNotification(Context context) {
		super(context, "mail.notification");
		setCreateWriteLocal(true);
	}

	@Override
	public ODomain defaultDomain() {
		ODomain domain = new ODomain();
		domain.add("partner_id", "=", user().getPartner_id());
		return domain;
	}

	@Override
	public Boolean checkForLocalLatestUpdate() {
		return false;
	}

	@Override
	public Boolean checkForLocalUpdate() {
		return false;
	}

	@Override
	public Boolean canCreateOnServer() {
		return false;
	}

	@Override
	public Boolean canDeleteFromLocal() {
		return false;
	}

	@Override
	public Boolean canDeleteFromServer() {
		return false;
	}

	@Override
	public Boolean canUpdateToServer() {
		return false;
	}

	@Override
	public Boolean checkForCreateDate() {
		return false;
	}

	@Override
	public Boolean checkForWriteDate() {
		return false;
	}
}