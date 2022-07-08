import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ChartDataset, ChartOptions } from 'chart.js';
import { ToastrService } from 'ngx-toastr';
import { AutenticacionService } from 'src/app/servicios/autenticacion.service';
import { DatosPorfolioService } from 'src/app/servicios/datos-porfolio.service';


@Component({
  selector: 'app-habilidades',
  templateUrl: './habilidades.component.html',
  styleUrls: ['./habilidades.component.css']
})
export class HabilidadesComponent implements OnInit {

  public habilidades: any;
  usuarioAutenticado: any;  

  graficoChartId: any[] = [];
  graficoChartOptions: ChartOptions = {responsive: true};
  graficoChartDataSet: ChartDataset[] = [
    /*{
      data: [60, 40],
      borderColor: '#1c1c1c',
      backgroundColor: ['#AB0000', '#1c1c1c']
    }*/
  ];
  graficoChartLabels: String[] = [];
  
  constructor(
    private datosPortfolioServicio: DatosPorfolioService, 
    private autenticacionServicio: AutenticacionService,
    private toaster: ToastrService,
    private router: Router
  ) {  }

  ngOnInit(): void {
    this.datosPortfolioServicio.verHabilidades().subscribe(data => {
      this.habilidades = data;
      console.log(this.habilidades);
      for (const item of this.habilidades) {
        this.graficoChartDataSet.push ({data: [item.porcentajeDominio, 100-item.porcentajeDominio], backgroundColor:["#AB0000", "#1c1c1c"], borderColor:['#1c1c1c']});
        this.graficoChartLabels.push(item.nombre);
        this.graficoChartId.push(item.id)
      }
      this.usuarioAutenticado = this.autenticacionServicio.usuarioAutenticado.tokenDeAcceso;

      console.log(this.graficoChartDataSet);
      console.log(this.graficoChartLabels);
    });
  }

  onDelete(id: number): void {
    console.log('Borrar habilidad ' + id);
    this.datosPortfolioServicio.eliminarHabilidad(id).subscribe(
      data => {
        this.ngOnInit();
      },
      err => {
        console.log('eliminado');
        this.toaster.success('Habilidad eliminada', '', {
          timeOut: 3800, positionClass: 'toast-top-center'
        });
        this.router.navigateByUrl('/RefrshComponent', {skipLocationChange: true}).then(()=> this.router.navigate(['/habilidades']));

      }
    );
  }

  
}
