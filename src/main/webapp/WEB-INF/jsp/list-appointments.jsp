<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
	<div>
		<a type="button" class="btn btn-primary btn-md" href="add-appointment">Add Appointments</a>
	</div>
	<br>
	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3>List of Upcoming Appointment's</h3>
		</div>
		<div class="panel-body">
			<table class="table table-striped">
				<thead>
					<tr>
						<th >Doctor Name</th>
						<th>Patient Name</th>
						<th>Appointment Date</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${appointments}" var="appointment">
						<tr>
							<td>${appointment.doctorName}</td>
							<td>${appointment.patientName}</td>
							<td><fmt:formatDate value="${appointment.date}"
									pattern="dd/MM/yyyy" /></td>
							<td><!--  >a type="button" class="btn btn-success"
								href="/update-appointment?id=${appointment.id}">Completed</a-->
							<a type="button" class="btn btn-warning"
								href="/delete-appointment?id=${appointment.id}">Cancel</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</div>
<%@ include file="common/footer.jspf"%>