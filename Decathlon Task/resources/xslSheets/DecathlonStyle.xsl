<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="competition">

		<html>
			<body>
				<h2>Decathlon</h2>
				<table border="1">
					<tr bgcolor="#9acd32">
						<th>Competition scores</th>
						<th>Final score</th>
						<th>Place</th>
					</tr>
					<xsl:for-each select="competition/singleuser">
						<tr>
							<td>
								<xsl:value-of select="participant" />
							</td>
							<td>
								<xsl:value-of select="score" />
							</td>
							<td>
								<xsl:value-of select="place" />
							</td>
						</tr>
					</xsl:for-each>
				</table>
			</body>
		</html>
	</xsl:template>
	
</xsl:stylesheet>