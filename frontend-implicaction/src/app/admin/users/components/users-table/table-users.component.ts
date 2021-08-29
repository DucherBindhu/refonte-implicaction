import {Component} from '@angular/core';
import {UserService} from '../../../../shared/services/user.service';
import {ToasterService} from '../../../../core/services/toaster.service';
import {take} from 'rxjs/operators';
import {LazyLoadEvent} from 'primeng/api';
import {Pageable} from '../../../../shared/models/pageable';
import {Constants} from '../../../../config/constants';

@Component({
  selector: 'app-table-users',
  templateUrl: './table-users.component.html',
  styleUrls: ['./table-users.component.scss']
})
export class TableUsersComponent {

  loading = true;

  // Pagination
  rowsPerPageOptions = [10, 25, 50];
  rowsPerPage = this.rowsPerPageOptions[0];
  pageable: Pageable = Constants.PAGEABLE_DEFAULT;

  constructor(
    private userService: UserService,
    private toastServices: ToasterService,
  ) {
  }

  loadUsers(event: LazyLoadEvent): void {
    this.loading = true;
    const page = event.first / event.rows;

    this.userService
      .getAll({page, size: event.rows})
      .pipe(take(1))
      .subscribe(
        users => this.pageable = users,
        () => this.toastServices.error('Oops', 'Une erreur est survenue lors de la récupération des données'),
        () => this.loading = false
      );
  }
}