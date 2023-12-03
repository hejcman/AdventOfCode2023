
SCALA_CLI="scala-cli"

.PHONY: test fmt

run:
	$(SCALA_CLI) .

test:
	$(SCALA_CLI) test .

fmt:
	$(SCALA_CLI) format .

clean:
	$(SCALA_CLI) clean .

compile: test fmt clean
	$(SCALA_CLI) --power package --standalone --main-class aoc2023.AoC2023 --output aoc2023 --force .