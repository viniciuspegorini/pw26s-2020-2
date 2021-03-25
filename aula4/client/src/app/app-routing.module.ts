import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CategoriaFormComponent } from './categoria/categoria-form/categoria-form.component';
import { CategoriaListComponent } from './categoria/categoria-list/categoria-list.component';
import { HomeComponent } from './home/home.component';

const routes: Routes = [
  { path: '', redirectTo: 'home' , pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  { path: 'categoria', component: CategoriaListComponent },
  { path: 'categoria/new', component: CategoriaFormComponent },
  { path: 'categoria/:id', component: CategoriaFormComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
