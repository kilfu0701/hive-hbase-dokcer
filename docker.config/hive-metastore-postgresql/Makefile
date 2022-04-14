current_branch := $(shell git rev-parse --abbrev-ref HEAD)
build:
	docker build -t kilfu0701/hive-metastore-postgresql:$(current_branch) ./
