import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PagLayoutComponent } from './pag-layout/pag-layout.component';
import { BoloListComponent } from './bolo/bolo-list/bolo-list.component';
import { PaisesListComponent } from './paises/paises-list/paises-list.component';
import { TemplateDriveComponent } from './cadastros/template-drive/template-drive.component';
import { ModelDriveComponent } from './cadastros/model-drive/model-drive.component';
import { MenuPagLayoutComponent } from './menu-pag-layout/menu-pag-layout.component';

const routes: Routes = [{
  path: '',
  component: MenuPagLayoutComponent,
  children: [
    { path: 'bolo', component: BoloListComponent },
    { path: 'paises', component: PaisesListComponent },
    { path: 'templateform', component: TemplateDriveComponent },
    { path: 'modelform', component: ModelDriveComponent },
    { path: 'adm', loadChildren: () => import('./admin/admin.module').then(m => m.AdminModule) },
  ]
}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
