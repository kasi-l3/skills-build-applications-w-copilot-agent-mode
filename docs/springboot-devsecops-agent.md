# Spring Boot + DevSecOps Agent (Repository Customization)

This repository includes a reusable Copilot agent prompt and instruction profile for short, practical Q&A on:

- Spring Boot
- Security
- Login / Authentication / Authorization
- DevSecOps real-world concerns (CI/CD security, secrets, scanning, secure defaults)

## Files

- `.github/instructions/springboot_devsecops_assistant.instructions.md`
- `.github/prompts/springboot-devsecops-assistant.prompt.md`

## How to use in Copilot Chat

1. Open Copilot Chat in VS Code.
2. Select **Agent** mode.
3. Run prompt file:

```text
/springboot-devsecops-assistant
```

4. Ask keyword prompts like:
   - `spring boot`
   - `security`
   - `login`
   - `authentication`
   - `authorization`
   - `jwt`
   - `oauth2`
   - `devsecops`

## How to test this agent

Run these manual tests in Copilot Chat after loading `/springboot-devsecops-assistant`.

### Test 1: Short keyword routing
Prompt:

```text
spring boot
```

Expected result:
- agent asks a short routing question with compact options (like `1/2/3`),
- does not jump into a long implementation.

### Test 2: No-assumption behavior
Prompt:

```text
Need secure login for my app
```

Expected result:
- agent asks exactly one short clarifying question first (for example `JWT / Session / OAuth2`),
- avoids assuming architecture or provider.

### Test 3: Crisp answer format
Prompt:

```text
How do I secure Spring Boot REST APIs?
```

Expected result:
- direct answer first,
- short output (typically <= 7 bullets unless asked for more),
- practical next action included.

### Test 4: DevSecOps scope
Prompt:

```text
Give me DevSecOps checks for Spring Boot in CI/CD
```

Expected result:
- includes security-focused recommendations (example: dependency scanning, secrets handling, SAST/DAST, auditability),
- keeps guidance concise and business-practical.

### Test 5: Compact clarification choices
Prompt:

```text
authentication
```

Expected result:
- clarification is compact (`yes/no`, `1/2/3`, or `ok to proceed`),
- no long questionnaire.

## Quick acceptance checklist

Mark pass if all are true:

- [ ] Answers are short and crisp.
- [ ] Agent does not assume missing requirements.
- [ ] If context is missing, agent asks one short question first.
- [ ] Clarifying questions use compact choices (1/2/3 or yes/no).
- [ ] Spring Boot + DevSecOps topics are handled with secure defaults.

## Response behavior (configured)

The assistant is configured to:
- keep answers short and crisp,
- avoid assumptions,
- ask a single short clarifying question when context is missing,
- use compact options (1/2/3, yes/no, ok).
