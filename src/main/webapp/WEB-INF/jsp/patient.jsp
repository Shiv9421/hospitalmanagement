<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
	<div class="row">
		<div class="col-md-6 col-md-offset-3 ">
			<div class="panel panel-primary">
				<div class="panel-heading">Add Patient</div>
				<div class="panel-body">
					<form:form method="post" modelAttribute="patient">
						<form:hidden path="id" />
						<fieldset class="form-group">
							<form:label path="patientName">Patient Name</form:label>
							<form:input path="patientName" type="text" class="form-control"
								required="required" />
							<form:errors path="patientName" cssClass="text-warning" />
						</fieldset>
						<fieldset class="form-group">
							<form:label path="patientAddress">Patient Address</form:label>
							<form:input path="patientAddress" type="text" class="form-control"
								required="required" />
							<form:errors path="patientAddress" cssClass="text-warning" />
						</fieldset>

						<fieldset class="form-group">
							<form:label path="mobileNumber">Mobile Number</form:label>
							<form:input path="mobileNumber" type="text" class="form-control"
								required="required" />
							<form:errors path="mobileNumber" cssClass="text-warning" />
						</fieldset>

						<button type="submit" class="btn btn-success">Save</button>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>
<%@ include file="common/footer.jspf"%>