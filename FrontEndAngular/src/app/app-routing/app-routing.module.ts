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
import { IniciarSesionComponent } from '../componentes/iniciar-sesion/iniciar-sesion.component';
import { NuevaExperienciaComponent } from '../componentes/experiencia/nueva-experiencia.component';
import { EditarExperienciaComponent } from '../componentes/experiencia/editar-experiencia.component';

import { GuardGuard } from '../servicios/guard.guard';
import { EliminarExperienciaComponent } from '../componentes/experiencia/eliminar-experiencia.component';
 


const routes: Routes = [
  {path: 'iniciar-sesion', component:IniciarSesionComponent},
  {path: 'acerca-de', component:AcercaDeComponent},
  {path: 'formacion', component:FormacionComponent},
  {path: 'experiencia', component:ExperienciaComponent},
  {path: 'nuevaExperiencia', component:NuevaExperienciaComponent, canActivate:[GuardGuard]},
  {path: 'editarExperiencia/:id', component:EditarExperienciaComponent, canActivate:[GuardGuard]},
  {path: 'eliminarExperiencia/:id', component:EliminarExperienciaComponent, canActivate:[GuardGuard]},
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
