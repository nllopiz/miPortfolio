import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { HeaderComponent } from './componentes/header/header.component';
import { AcercaDeComponent } from './componentes/acerca-de/acerca-de.component';
import { ExperienciaComponent } from './componentes/experiencia/experiencia.component';
import { FormacionComponent } from './componentes/formacion/formacion.component';
import { HabilidadesComponent } from './componentes/habilidades/habilidades.component';
import { ProyectosComponent } from './componentes/proyectos/proyectos.component';
import { FooterComponent } from './componentes/footer/footer.component';

import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { AppRouting } from './app-routing/app-routing.module';
import { PageNotFoundComponent } from './componentes/page-not-found/page-not-found.component';

import { NgChartsModule } from 'ng2-charts';
import { InteresesComponent } from './componentes/intereses/intereses.component';
import { IniciarSesionComponent } from './componentes/iniciar-sesion/iniciar-sesion.component';
import { ReactiveFormsModule } from '@angular/forms';
import { DatosPorfolioService } from './servicios/datos-porfolio.service';
import { InterceptorService } from './servicios/interceptor.service';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    AcercaDeComponent,
    ExperienciaComponent,
    FormacionComponent,
    HabilidadesComponent,
    ProyectosComponent,
    FooterComponent,
    PageNotFoundComponent,
    InteresesComponent,
    IniciarSesionComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRouting,
    NgChartsModule,
    ReactiveFormsModule
  ],
  providers: [
    DatosPorfolioService,
    { provide: HTTP_INTERCEPTORS, 
      useClass: InterceptorService,
      multi: true
    },
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
