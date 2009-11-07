package modules.customerVendor;

import java.util.GregorianCalendar;

import modules.customerVendor.entityDefinitions.Merchant;
import modules.customerVendor.entityDefinitions.Invoice;
import newtonERP.module.BaseAction;
import newtonERP.module.Module;

/**
 * Représente le module client-fournisseur (facturation et factures de
 * fournisseur + le marketing )
 * @author r3lemaypa Guillaume cloutierJo
 */
public class CustomerVendor extends Module
{
    /**
     * constructeur
     * @throws Exception remonte
     */
    public CustomerVendor() throws Exception
    {
	super();
	setDefaultAction(new BaseAction("GetList", new Merchant()));

	addGlobalActionMenuItem("Clients", new BaseAction("GetList",
		new Merchant()));

	addGlobalActionMenuItem("Factures", new BaseAction("GetList",
		new Invoice()));

	setVisibleName("Clients / Fournisseurs");
    }

    public void initDB() throws Exception
    {
	super.initDB();

	Merchant customer3 = new Merchant();
	customer3.setData("name", "Nous");
	customer3.setData("phone", "555-5555");
	customer3.setData("addressID", 1); // Un peu bâtard par ce qu'on assume
	// qu'il y a une adresse ayant comme
	// primary key cette valeur
	customer3.newE();

	Merchant customer = new Merchant();
	customer.setData("name", "Bombardier");
	customer.setData("phone", "514-345-6575");
	customer.setData("addressID", 2);
	customer.newE();

	Merchant customer1 = new Merchant();
	customer1.setData("name", "Hydro-Québec");
	customer1.setData("phone", "514-780-4568");
	customer1.setData("addressID", 3);
	customer1.newE();

	Merchant customer2 = new Merchant();
	customer2.setData("name", "Arborite");
	customer2.setData("phone", "514-266-2710");
	customer2.setData("addressID", 3);
	customer2.newE();

	Invoice invoice = new Invoice();
	invoice.setData("total", 45.16);
	invoice.setData("customerID", 2);
	invoice.setData("date", new GregorianCalendar());
	invoice.newE();
    }
}