import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { HeaderComponent } from './componentes/header/header.component';
import { AcercaDeComponent } from './componentes/acerca-de/acerca-de.component';
import { ExperienciaComponent } from './componentes/experiencia/experiencia.component';
import { FormacionComponent } from './componentes/formacion/formacion.component';
import { SkillsComponent } from './componentes/skills/skills.component';
import { ProyectosComponent } from './componentes/proyectos/proyectos.component';
import { FooterComponent } from './componentes/footer/footer.component';

import { HttpClientModule } from '@angular/common/http';
import { AppRouting } from './app-routing/app-routing.module';
import { PageNotFoundComponent } from './componentes/page-not-found/page-not-found.component';

import { NgChartsModule } from 'ng2-charts';
import { InteresesComponent } from './componentes/intereses/intereses.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    AcercaDeComponent,
    ExperienciaComponent,
    FormacionComponent,
    SkillsComponent,
    ProyectosComponent,
    FooterComponent,
    PageNotFoundComponent,
    InteresesComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRouting,
    NgChartsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
