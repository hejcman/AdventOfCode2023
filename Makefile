
SCALA_CLI="scala-cli"

.PHONY: test fmt

run:
	$(SCALA_CLI) .

test:
	$(SCALA_CLI) test .

fmt:
	$(SCALA_CLI) format .
