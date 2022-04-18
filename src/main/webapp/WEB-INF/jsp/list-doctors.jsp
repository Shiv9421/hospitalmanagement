<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
	<div>
		<a type="button" class="btn btn-primary btn-md" href="add-doctor">Add Doctor</a>
	</div>
	<br>
	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3>List of Doctor's</h3>
		</div>
		<div class="panel-body">
			<table class="table table-striped">
				<thead>
					<tr>
						<th >Doctor Name</th>
						<th>Specialisation</th>
						<th>Joining Date</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${doctors}" var="doctor">
						<tr>
							<td>${doctor.doctorName}</td>
							<td>${doctor.specialisation}</td>
							<td><fmt:formatDate value="${doctor.joiningDate}"
									pattern="dd/MM/yyyy" /></td>
							<td><a type="button" class="btn btn-success"
								href="/update-doctor?id=${doctor.id}">Update</a>
							<a type="button" class="btn btn-warning"
								href="/delete-doctor?id=${doctor.id}">Delete</a>
							<a type="button" class="btn btn-success"
								href="/get-appointments?id=${doctor.id}">Check Appointments</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</div>
<%@ include file="common/footer.jspf"%>