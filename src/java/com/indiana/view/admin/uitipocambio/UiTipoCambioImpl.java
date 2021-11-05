package com.indiana.view.admin.uitipocambio;

import java.util.List;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.indiana.client.service.ServiceGestionMantenimiento;
import com.indiana.client.service.ServiceGestionMantenimientoAsync;
import com.indiana.server.model.bean.TipoCambio;
import com.indiana.view.admin.uimanttipocambio.UiMantTipoCambio;
import com.indiana.view.admin.uimanttipocambio.UiMantTipoCambioImpl;
import com.indiana.view.uiutil.UiMantenimiento;

import gwt.material.design.client.ui.MaterialToast;

public class UiTipoCambioImpl extends UiTipoCambio{
	private UiMantTipoCambio ui;
	private final ServiceGestionMantenimientoAsync SERVICE = GWT
			.create(ServiceGestionMantenimiento.class);
	
	public UiTipoCambioImpl(){
		loadTable();
	}
	
	@Override
    public void loadTable() {
		SERVICE.listTipoCambio(new AsyncCallback<List<TipoCambio>>(){

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				MaterialToast.fireToast(caught.getMessage());
			}

			@Override
			public void onSuccess(List<TipoCambio> result) {
				// TODO Auto-generated method stub
				grid.getSelectionModel().clear();
				grid.setData(result);
			}});
	}
	
	public void goToUiMantTipoCambioInsertar() {
		// TODO Auto-generated method stub
		if (ui == null) {
			ui = new UiMantTipoCambioImpl(this);
			ui.setModo(UiMantenimiento.MODOINSERTAR);
			ui.loadFields();
			ui.show();
		} else {
			ui.setModo(UiMantenimiento.MODOINSERTAR);
			ui.loadFields();
			ui.show();
		}
	}

	@Override
	public void goToUiMantTipoCambioActualizar() {
		// TODO Auto-generated method stub
		TipoCambio bean = grid.getSelectionModel().getSelectedObject();
		if (bean != null) {
			if (ui == null) {
				ui = new UiMantTipoCambioImpl(this);
				ui.setModo(UiMantenimiento.MODOUPDATE);
				ui.setBean(bean);
				ui.loadFields();
				ui.show();
			} else {
				ui.setModo(UiMantenimiento.MODOUPDATE);
				ui.setBean(bean);
				ui.loadFields();
				ui.show();
			}
		} else {
			MaterialToast.fireToast("Seleccione una fila del grid");
		}
	}

	@Override
	public void goToUiMantTipoCambioEliminar() {
		// TODO Auto-generated method stub
		TipoCambio bean = grid.getSelectionModel().getSelectedObject();
		if (bean != null) {
			if (ui == null) {
				ui = new UiMantTipoCambioImpl(this);
				ui.setModo(UiMantenimiento.MODODELETE);
				ui.setBean(bean);
				ui.loadFields();
				ui.show();
			} else {
				ui.setModo(UiMantenimiento.MODODELETE);
				ui.setBean(bean);
				ui.loadFields();
				ui.show();
			}
		} else {
			MaterialToast.fireToast("Seleccione una fila del grid");
		}
	}

	@Override
	public void goToUiMantTipoCambioDetalle() {
		// TODO Auto-generated method stub
		TipoCambio bean = grid.getSelectionModel().getSelectedObject();
		if (bean != null) {
			if (ui == null) {
				ui = new UiMantTipoCambioImpl(this);
				ui.setModo(UiMantenimiento.MODODETALLE);
				ui.setBean(bean);
				ui.loadFields();
				ui.show();
			} else {
				ui.setModo(UiMantenimiento.MODODETALLE);
				ui.setBean(bean);
				ui.loadFields();
				ui.show();
			}
		} else {
			MaterialToast.fireToast("Seleccione una fila del grid");
		}
	}
}



