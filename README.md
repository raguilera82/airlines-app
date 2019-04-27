# Airlines App Spring Boot Kubernetes Example

## Set Docker registry

```
kubectl create \
    secret docker-registry nexus-docker \
    --docker-server=nexus-local.tntformacion.com:10000 \
    --docker-username=admin \
    --docker-password=tec.82sup \
    --docker-email=admin@example.org --namespace=devops-airlines-app
```