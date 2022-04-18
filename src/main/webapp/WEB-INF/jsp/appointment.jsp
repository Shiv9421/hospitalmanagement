<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
	<div class="row">
		<div class="col-md-6 col-md-offset-3 ">
			<div class="panel panel-primary">
				<div class="panel-heading">Add Appointment</div>
				<div class="panel-body">
					<form:form method="post" modelAttribute="appointment">
						<form:hidden path="id" />
						<fieldset class="form-group">
							<form:label path="patientName">Patient Name</form:label>
							<form:select path="patientName">
								<option>Select Patient</option>
								<c:forEach items="${patientList}" var="patient">
                            		<option>${patient.patientName}</option>
                          	  </c:forEach>
							</form:select>
							<form:errors path="patientName" cssClass="text-warning" />
						</fieldset>
						<fieldset class="form-group">
							<form:label path="doctorName">Doctor Name</form:label>
							<form:select path="doctorName">
								<option>Select Doctor</option>
								<c:forEach items="${doctorList}" var="doctor">
                            		<option>${doctor.doctorName}</option>
                            </c:forEach>
							</form:select>
							<form:errors path="doctorName" cssClass="text-warning" />
						</fieldset>

						<fieldset class="form-group">
							<form:label path="date">Appointment Date</form:label>
							<form:input path="date" type="text" class="form-control"
								required="required" />
							<form:errors path="date" cssClass="text-warning" />
						</fieldset>
						
						

						<button type="submit" class="btn btn-success">Save</button>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>
<%@ include file="common/footer.jspf"%>