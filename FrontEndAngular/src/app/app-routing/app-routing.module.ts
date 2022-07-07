import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';

import { AcercaDeComponent } from '../componentes/acerca-de/acerca-de.component';
import { FormacionComponent } from '../componentes/formacion/formacion.component';
import { ExperienciaComponent } from '../componentes/experiencia/experiencia.component';
import { HabilidadesComponent } from '../componentes/habilidades/habilidades.component';
import { ProyectosComponent } from '../componentes/proyectos/proyectos.component';
import { PageNotFoundComponent } from '../componentes/page-not-found/page-not-found.component';
import { IniciarSesionComponent } from '../componentes/iniciar-sesion/iniciar-sesion.component';
import { NuevaExperienciaComponent } from '../componentes/experiencia/nueva-experiencia.component';
import { EditarExperienciaComponent } from '../componentes/experiencia/editar-experiencia.component';

import { GuardGuard } from '../servicios/guard.guard'; 
import { EditarFormacionComponent } from '../componentes/formacion/editar-formacion.component';
import { NuevaFormacionComponent } from '../componentes/formacion/nueva-formacion.component';
import { EditarProyectoComponent } from '../componentes/proyectos/editar-proyecto.component';
import { NuevoProyectoComponent } from '../componentes/proyectos/nuevo-proyecto.component';
import { EditarAcercaDeComponent } from '../componentes/acerca-de/editar-acerca-de.component';
import { NuevaHabilidadComponent } from '../componentes/habilidades/nueva-habilidad.component';
import { EditarHabilidadComponent } from '../componentes/habilidades/editar-habilidad.component';


const routes: Routes = [
  {path: 'iniciar-sesion', component:IniciarSesionComponent},
  {path: 'acerca-de', component:AcercaDeComponent},
  {path: 'editarAcerca-de/:id', component:EditarAcercaDeComponent},
  {path: 'experiencia', component:ExperienciaComponent},
  {path: 'nuevaExperiencia', component:NuevaExperienciaComponent, canActivate:[GuardGuard]},
  {path: 'editarExperiencia/:id', component:EditarExperienciaComponent, canActivate:[GuardGuard]},
  {path: 'formacion', component:FormacionComponent},
  {path: 'editarFormacion/:id', component:EditarFormacionComponent, canActivate:[GuardGuard]},
  {path: 'nuevaFormacion', component:NuevaFormacionComponent, canActivate:[GuardGuard]},
  {path: 'habilidades', component:HabilidadesComponent},
  {path: 'editarHabilidad/:id', component:EditarHabilidadComponent, canActivate:[GuardGuard]},
  {path: 'nuevaHabilidad', component:NuevaHabilidadComponent, canActivate:[GuardGuard]},
  {path: 'proyectos', component:ProyectosComponent},
  {path: 'editarProyecto/:id', component:EditarProyectoComponent, canActivate:[GuardGuard]},
  {path: 'nuevoProyecto', component: NuevoProyectoComponent, canActivate:[GuardGuard]},
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
