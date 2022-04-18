<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
	<div>
		<a type="button" class="btn btn-primary btn-md" href="add-patient">Add Patient</a>
	</div>
	<br>
	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3>List of Patient's</h3>
		</div>
		<div class="panel-body">
			<table class="table table-striped">
				<thead>
					<tr>
						<th >Patient Name</th>
						<th>Patient Address</th>
						<th>Mobile Number</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${patients}" var="patient">
						<tr>
							<td>${patient.patientName}</td>
							<td>${patient.patientAddress}</td>
							<td>${patient.mobileNumber}</td>
							<td><a type="button" class="btn btn-success"
								href="/update-patient?id=${patient.id}">Update</a>
							<a type="button" class="btn btn-warning"
								href="/delete-patient?id=${patient.id}">Delete</a>
							<a type="button" class="btn btn-success"
								href="/check-appointments?id=${patient.id}">Check Appointments</a>
								</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</div>
<%@ include file="common/footer.jspf"%>