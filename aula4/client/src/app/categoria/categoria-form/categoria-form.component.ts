import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Categoria } from '../model/categoria';
import { CategoriaService } from '../service/categoria.service';

@Component({
  selector: 'app-categoria-form',
  templateUrl: './categoria-form.component.html',
  styleUrls: ['./categoria-form.component.scss']
})
export class CategoriaFormComponent implements OnInit {

  categoria: Categoria;

  constructor(private categoriaService: CategoriaService,
    private router: Router,
    private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.categoria = new Categoria();
    const id = Number(this.route.snapshot.params.id);
    if (id) {
      this.categoriaService.findOne(id).subscribe(e => {
        this.categoria = e;
      });
    }
  }

  save(): void {
    this.categoriaService.save(this.categoria).subscribe(e => {
      this.router.navigate(['categoria']);
    }, error => {
      console.error('Erro ao salvar a categoria');
    });
  }

  cancel(): void {
    this.router.navigate(['categoria']);
  }
}
