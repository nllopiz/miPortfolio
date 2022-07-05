import { Component, OnInit } from '@angular/core';
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

  graficoChartOptions: ChartOptions = {responsive: true};
  graficoChartDataSet: ChartDataset[] = [];
  graficoChartLabels: String[] = [];
  graficoChartBgColor: any[] = [
    { 
      backgroundColor:["#ddd", "#6FC8CE", "#FAFFF2", "#FFFCC4", "#B9E8E0"] 
    }];
  
  constructor(
    private datosPortfolioServicio: DatosPorfolioService, 
    private autenticacionServicio: AutenticacionService,
    private toaster: ToastrService
  ) {  }

  ngOnInit(): void {
    this.datosPortfolioServicio.verHabilidades().subscribe(data => {
      this.habilidades = data;
      console.log(this.habilidades)
      for (const item of this.habilidades) {
        this.graficoChartDataSet.push ({data: item.porcentajes});
        this.graficoChartLabels.push(item.nombre);
      }
      this.usuarioAutenticado = this.autenticacionServicio.usuarioAutenticado.tokenDeAcceso;
      console.log('dataset: ' + this.graficoChartDataSet);
      console.log('labels' + this.graficoChartLabels);
    });
  }

  onDelete(id: number): void {
    console.log('Borrar proyecto ' + id);
    this.datosPortfolioServicio.eliminarProyecto(id).subscribe(
      data => {
        this.ngOnInit();
      },
      err => {
        console.log('eliminado');
        this.toaster.success('Proyecto eliminado', 'OK', {
          timeOut: 3800, positionClass: 'toast-top-center'
        });
        this.ngOnInit();
      }
    );
  }

  public chartColors() {
    return [{
      backgroundColor: '#ddd',
      borderColor: 'rgba(225,10,24,0.2)',
      pointBackgroundColor: 'rgba(225,10,24,0.2)',
      pointBorderColor: '#fff',
      pointHoverBackgroundColor: '#fff',
      pointHoverBorderColor: 'rgba(225,10,24,0.2)'
  }]
}

  
}
