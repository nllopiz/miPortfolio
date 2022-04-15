import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';

import { AcercaDeComponent } from '../componentes/acerca-de/acerca-de.component';
import { FormacionComponent } from '../componentes/formacion/formacion.component';
import { ExperienciaComponent } from '../componentes/experiencia/experiencia.component';
import { HabilidadesComponent } from '../componentes/habilidades/habilidades.component';
import { ProyectosComponent } from '../componentes/proyectos/proyectos.component';
import { PageNotFoundComponent } from '../componentes/page-not-found/page-not-found.component';
import { InteresesComponent } from '../componentes/intereses/intereses.component';


const routes: Routes = [
  {path: 'acerca-de', component:AcercaDeComponent},
  {path: 'formacion', component:FormacionComponent},
  {path: 'experiencia', component:ExperienciaComponent},
  {path: 'skills', component:HabilidadesComponent},
  {path: 'proyectos', component:ProyectosComponent},
  {path: 'intereses', component:InteresesComponent},
  {path: '', redirectTo: 'acerca-de', pathMatch: 'full'},
  {path: '**', component:PageNotFoundComponent}

];


@NgModule({
  declarations: [],
  imports: [
    CommonModule, 
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})
export class AppRouting { }
