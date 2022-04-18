<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
	<div class="row">
		<div class="col-md-6 col-md-offset-3 ">
			<div class="panel panel-primary">
				<div class="panel-heading">Add Doctor</div>
				<div class="panel-body">
					<form:form method="post" modelAttribute="doctor">
						<form:hidden path="id" />
						<fieldset class="form-group">
							<form:label path="doctorName">Doctor Name</form:label>
							<form:input path="doctorName" type="text" class="form-control"
								required="required" />
							<form:errors path="doctorName" cssClass="text-warning" />
						</fieldset>
						<fieldset class="form-group">
							<form:label path="specialisation">Specialisation</form:label>
							<form:input path="specialisation" type="text" class="form-control"
								required="required" />
							<form:errors path="specialisation" cssClass="text-warning" />
						</fieldset>

						<fieldset class="form-group">
							<form:label path="joiningDate">Joining Date</form:label>
							<form:input path="joiningDate" type="text" class="form-control"
								required="required" />
							<form:errors path="joiningDate" cssClass="text-warning" />
						</fieldset>

						<button type="submit" class="btn btn-success">Save</button>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>
<%@ include file="common/footer.jspf"%>