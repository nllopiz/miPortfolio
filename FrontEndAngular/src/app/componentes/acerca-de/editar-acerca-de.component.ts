import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Persona } from 'src/app/modelos/persona';
import { DatosPorfolioService } from 'src/app/servicios/datos-porfolio.service';

@Component({
  selector: 'app-editar-acerca-de',
  templateUrl: './editar-acerca-de.component.html',
  styleUrls: ['./editar-acerca-de.component.css']
})
export class EditarAcercaDeComponent implements OnInit {

  persona: Persona = new Persona('','','','','','','');
  misDatos: any;


  constructor(
    private datosPorfolioServicio: DatosPorfolioService,
    private activatedRoute: ActivatedRoute,
    private toaster: ToastrService,
    private rutas: Router
  ) { }

  ngOnInit(): void {
    this.datosPorfolioServicio.verPersona().subscribe(
      data => {
      this.misDatos=data;
      console.log(this.misDatos);
      },
      err => {
        this.toaster.error('Fallo al cargar la proyecto', 'Fail', {
          timeOut: 3800, positionClass: 'toast-top-center'
        });
        this.rutas.navigate(['/acerca-de']);
      }
    );
    
  }

  onUpdate(): void {
    this.datosPorfolioServicio.editarPersona(this.misDatos).subscribe(
      data => {
        this.toaster.success('Datos actualizados', 'OK', {
          timeOut: 3800, positionClass: 'toast-top-center'
        });
        this.rutas.navigate(['./acerca-de']);
      }
    )

  }

 

}
